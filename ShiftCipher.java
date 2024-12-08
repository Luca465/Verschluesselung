
public class ShiftCipher extends MonoAlphabeticCipher{
    private int shiftValue;

    /**
     * Creates a new ShiftCipher object with the given shift value.
     * @param shiftValue the shift value
     */
    public ShiftCipher(int shiftValue) {
        this.setShiftValue(shiftValue);
    }

    /**
     * Returns the shift value.
     * @return the shift value
     */
    public int getShiftValue() {
        return shiftValue;
    }

    /**
     * Sets how much the alphabet should be shifted.
     * Negative values shift to the left, For numbers greater than the alphabet length, the modulo is taken.
     * @param shiftValue the new shift value
     */
    public void setShiftValue(int shiftValue) {
        if (shiftValue < 0) {
            shiftValue %= super.ALPHABET.length();
            shiftValue += super.ALPHABET.length();
        } else {
            shiftValue %= super.ALPHABET.length();
        }
        this.shiftValue = shiftValue;

        char[] alph = super.ALPHABET.toCharArray();
        char[] alphShifted = new char[super.ALPHABET.length()];
        int indexBeforeShifted = 0;
        for (int i = 0; i < super.ALPHABET.length(); i++) {
            if (i + this.shiftValue < alph.length) {
                alphShifted[i] = alph[i + this.shiftValue];
            } else {
                alphShifted[i] = alph[indexBeforeShifted];
                indexBeforeShifted++;
            }
        }
        super.setSecretAlphabet(new String(alphShifted));
    }

    /**
     * Returns a string representation of the shift cipher.
     * @return the description
     */
    @Override
    public String getDescription() {
        return "Verschiebung (" + this.getShiftValue() + ")";
    }
}
