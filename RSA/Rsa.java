import java.math.BigInteger;

public class Rsa {

    /**
     * This method generates a new KeyPair object
     * @return This returns a KeyPair object used for RSA
     */
    private static KeyPair generateKeyPair() {
        // TODO: Implement algorithm for creating each of these BigInteger objects
        BigInteger publicKey = null;
        BigInteger publicKeyExp = null;
        BigInteger privateKey = null;
        return new KeyPair(publicKey, publicKeyExp, privateKey);
    }

    /**
     * This method encrypts a message with a public key and its exponent
     * @param m This is the plain message as a byte array
     * @param n This is the public key
     * @param e This is the public key exponent
     * @return byte[] This returns the encrypted message
     */
    private static byte[] encrypt(byte[] m, byte[] n, byte[] e) {
        final BigInteger message = new BigInteger(m);
        final BigInteger publicKey = new BigInteger(n);
        final BigInteger publicKeyExp = new BigInteger(e);
        final BigInteger encryptedMessage = message.modPow(publicKeyExp, publicKey);
        return encryptedMessage.toByteArray();
    }

    /**
     * This method decrypts a message with the private key and public key
     * @param c This is the encrypted message as a byte array
     * @param d This is the private key
     * @param n This is the public key
     * @return byte[] This returns the decrypted message
     */
    private static byte[] decrypt(byte[] c, byte[] d, byte[] n) {
        final BigInteger encryptedMessage = new BigInteger(c);
        final BigInteger privateKey = new BigInteger(d);
        final BigInteger publicKey = new BigInteger(n);
        final BigInteger decryptedMessage = encryptedMessage.modPow(privateKey, publicKey);
        return decryptedMessage.toByteArray();
    }

    private static class KeyPair {
        private final byte[] publicKey, publicKeyExp, privateKey;

        KeyPair(BigInteger publicKey, BigInteger publicKeyExp, BigInteger privateKey) {
            this.publicKey = publicKey.toByteArray();
            this.publicKeyExp = publicKeyExp.toByteArray();
            this.privateKey = privateKey.toByteArray();
        }

        public byte[] getPublicKey() {
            return publicKey;
        }

        public byte[] getPublicKeyExp() {
            return publicKeyExp;
        }

        public byte[] getPrivateKey() {
            return privateKey;
        }
    }

    public static void main(String[] args) {
        KeyPair keyPair = generateKeyPair();
        // Can use this for testing

    }
}
