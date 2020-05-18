public String handleMessage(SOAPMessage message) {
        String ret;
        try {
            Document doc = message.getSOAPBody().getOwnerDocument();
            Crypto crypto = CryptoFactory.getInstance(properties); //File

            WSSecSignature sign = new WSSecSignature();
            sign.setUserInfo(properties.getProperty("org.apache.ws.security.crypto.merlin.keystore.alias"), properties.getProperty("privatekeypassword"));
            sign.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE); // Binary Security Token - SecurityTokenReference
            sign.setUseSingleCertificate(true);
            sign.setDigestAlgo(DigestMethod.SHA256);

            WSSecHeader secHeader = new WSSecHeader();
            secHeader.insertSecurityHeader(doc);
            Document signedDoc = sign.build(doc, crypto, secHeader);

            ret = org.apache.ws.security.util.XMLUtils.PrettyDocumentToString(signedDoc);

        } catch (SOAPException e) {
            e.printStackTrace();
            return null;
        } catch (WSSecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return ret;
    }