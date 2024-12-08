
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherController implements ActionListener {
    CipherPanel panel;
    CipherFrame frame;
    MonoAlphabeticCipher model;

    /**
     * Creates a new CipherController object.
     */
    public CipherController() {
        panel = new CipherPanel(this);
        frame = new CipherFrame("Gewinn", panel);
    }

    /**
     * Handles the actions performed by the user.
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        switch (ac) {
            case "encrypt" -> {
                if (panel.getSelectedItem().equals("Verschieben")) {
                    int arg;
                    try {
                        arg = Integer.parseInt(panel.getArgumentText());
                    } catch (NumberFormatException exc) {
                        panel.setDescriptionText("[Error] Argument must be number!");
                        break;
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Must provide argument!");
                        break;
                    }
                    model = new ShiftCipher(arg);
                } else {
                    String arg;
                    try {
                        arg = panel.getArgumentText();
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Must provide argument!");
                        break;
                    }
                    try {
                        model = new SubstitutionCipher(arg);
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Alphabet is invalid!");
                        break;
                    }
                }
                String inputText;
                try {
                    inputText = panel.getInputText();
                } catch (IllegalArgumentException exc) {
                    panel.setDescriptionText("[Error] Must provide input!");
                    break;
                }
                String enc = model.encrypt(inputText);
                panel.setOutputText(enc);
                panel.setDescriptionText("[Verschlüsselung] " + inputText + " -> " + enc);
            }
            case "decrypt" -> {
                if (panel.getSelectedItem().equals("Verschieben")) {
                    int arg;
                    try {
                        arg = Integer.parseInt(panel.getArgumentText());
                    } catch (NumberFormatException exc) {
                        panel.setDescriptionText("[Error] Argument must be number!");
                        break;
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Must provide argument!");
                        break;
                    }
                    model = new ShiftCipher(arg);
                } else {
                    String arg;
                    try {
                        arg = panel.getArgumentText();
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Must provide argument!");
                        break;
                    }
                    try {
                        model = new SubstitutionCipher(arg);
                    } catch (IllegalArgumentException exc) {
                        panel.setDescriptionText("[Error] Alphabet is invalid!");
                        break;
                    }
                }
                String inputText;
                try {
                    inputText = panel.getInputText();
                } catch (IllegalArgumentException exc) {
                    panel.setDescriptionText("[Error] Must provide input!");
                    break;
                }
                String enc = model.decrypt(inputText);
                panel.setOutputText(enc);
                panel.setDescriptionText("[Entschlüsselung] " + inputText + " -> " + enc);
            }
            case "selection" -> {
                if (panel.getSelectedItem().equals("Substitution")) {
                    panel.setDescriptionText("[Auswahl] Substitutionsverfahren");
                    panel.setArgumentLabel("Substituieren mit:");
                    panel.setArgumentPlaceholderAlphabet();
                } else {
                    panel.setDescriptionText("[Auswahl] Caesar-Verschlüsselung");
                    panel.setArgumentLabel("Verschieben um:");
                    panel.clearArgumentPlaceholder();
                }
            }
        }
    }

    public static void main(String[] args) {
        new CipherController();
    }
}
