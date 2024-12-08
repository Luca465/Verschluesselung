
public class SubstitutionCipher extends MonoAlphabeticCipher{
    /**
     * Creates a new SubstitutionCipher object with the given secret alphabet.
     * @param secretAlphabet the secret alphabet
     */
    public SubstitutionCipher(String secretAlphabet) {
        this.setSecretAlphabet(secretAlphabet);
    }

    /**
     * Sets the secret alphabet to the given string.
     * @param alphabet the new secret alphabet
     * @throws IllegalArgumentException if the given alphabet is invalid
     */
    @Override
    public void setSecretAlphabet(String alphabet) {
        if (this.isValidAlphabet(alphabet)) {
            super.setSecretAlphabet(alphabet);
        } else {
            throw new IllegalArgumentException("Alphabet is invalid!");
        }
    }

    /**
     * Checks if the given alphabet is valid.
     * Valid if: not null, all characters exist only once, all characters exist in the default alphabet
     * @param alphabet the alphabet to check
     * @return true if the alphabet is valid, false otherwise
     */
    private boolean isValidAlphabet(String alphabet) {
        // false if null
        if (alphabet == null) {
            return false;
        }

        // false if too short
        if (alphabet.length() != ALPHABET.length()) {
            return false;
        }

        // false if a character exists more than once
        int[] charCounts = new int[256];
        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            charCounts[c]++;
            if (charCounts[c] > 1) {
                return false;
            }
        }

        // false if not all characters exist
        for (int i = 0; i < alphabet.length(); i++) {
            int index = ALPHABET.indexOf(alphabet.charAt(i));
            if (index == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a description of the cipher.
     * @return the description
     */
    @Override
    public String getDescription() {
        return "Substitution (" + this.getSecretAlphabet() + ")";
    }
}
