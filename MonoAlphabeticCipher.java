
public class MonoAlphabeticCipher {
    private String secretAlphabet;
    protected String ALPHABET = "abcdefghijklmnopqrstuvwxyzäöüß";

    /**
     * Creates a new MonoAlphabeticCipher object with the default alphabet.
     */
    public MonoAlphabeticCipher() {
        secretAlphabet = ALPHABET;
    }

    /**
     * Returns a string representation of the saved secret alphabet.
     * @return the secret alphabet
     */
    public String getSecretAlphabet() {
        return secretAlphabet;
    }

    /**
     * Sets the secret alphabet to the given string.
     * @param alphabet the new secret alphabet
     * @throws IllegalArgumentException if the given alphabet is null
     */
    protected void setSecretAlphabet(String alphabet) throws IllegalArgumentException{
        if (alphabet == null) {
            throw new IllegalArgumentException("Alphabet invalid or null!");
        }
        this.secretAlphabet = alphabet;
    }

    /**
     * Encrypts the given text using the secret alphabet.
     * @param text the text to encrypt
     * @return the encrypted text
     */
    public String encrypt(String text) {
        StringBuilder enc = new StringBuilder();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            int index = ALPHABET.indexOf(text.charAt(i));
            if (index != -1) {
                enc.append(secretAlphabet.charAt(index));
            } else {
                enc.append(text.charAt(i));
            }
        }
        return enc.toString();
    }

    /**
     * Decrypts the given text using the secret alphabet.
     * @param text the text to decrypt
     * @return the decrypted text
     */
    public String decrypt(String text) {
        StringBuilder dec = new StringBuilder();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            int index = secretAlphabet.indexOf(text.charAt(i));
            if (index != -1) {
                dec.append(ALPHABET.charAt(index));
            } else {
                dec.append(text.charAt(i));
            }
        }
        return dec.toString();
    }

    /**
     * Returns a description of the cipher.
     * @return the description
     */
    public String getDescription() {
        return "Keine Verschlüsselung";
    }
}