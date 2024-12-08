
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class CipherPanel extends JPanel{
    private JButton encrypt, decrypt;
    private JTextField input, arg;
    private JLabel output, description, argL;
    private JComboBox dropdown;
    private CipherController controller;

    /**
     * Creates the program in its initial state.
     * @param controller the controller
     */
    public CipherPanel(CipherController controller) {
        this.controller = controller;

        this.setSize(getWidth(), getHeight());
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        JPanel buttons = new JPanel(new FlowLayout());
        encrypt = new JButton("Encrypt");
        encrypt.setActionCommand("encrypt");
        encrypt.addActionListener(controller);
        buttons.add(encrypt);
        decrypt = new JButton("Decrypt");
        decrypt.setActionCommand("decrypt");
        decrypt.addActionListener(controller);
        buttons.add(decrypt);
        this.add(buttons, BorderLayout.SOUTH);

        //top
        String[] options = {"Verschieben", "Substitution"};
        dropdown = new JComboBox(options);
        dropdown.setActionCommand("selection");
        dropdown.addActionListener(controller);
        this.add(dropdown, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(8, 1));

        JLabel inputL = new JLabel("Input:");
        inputL.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(inputL);
        input = new JTextField();
        input.setActionCommand("input");
        input.addActionListener(controller);
        center.add(input);

        argL = new JLabel("Verschieben um:");
        argL.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(argL);
        arg = new JTextField();
        arg.setActionCommand("arg");
        arg.addActionListener(controller);
        center.add(arg);

        JLabel outputL = new JLabel("Output:");
        outputL.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(outputL);

        JPanel outputF = new JPanel(new FlowLayout());
        outputF.setBackground(Color.WHITE);
        outputF.setBorder(new LineBorder(Color.GRAY));
        output = new JLabel();
        outputF.add(output);
        center.add(outputF);

        JLabel descriptionL = new JLabel("Description");
        descriptionL.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(descriptionL);

        JPanel descriptionF = new JPanel(new FlowLayout());
        descriptionF.setBackground(Color.WHITE);
        descriptionF.setBorder(new LineBorder(Color.GRAY));
        description = new JLabel("Input text to start");
        descriptionF.add(description);
        center.add(descriptionF);

        this.add(center, BorderLayout.CENTER);
    }

    /**
     * Sets the output text to the given string.
     * @param text the text to set
     */
    public void setOutputText(String text) {
        output.setText(text);
    }

    /**
     * Sets the description text to the given string.
     * @param text the text to set
     */
    public void setDescriptionText(String text) {
        description.setText(text);
    }

    /**
     * Sets the argument label to the given string.
     * @param text the text to set
     */
    public void setArgumentLabel(String text) {
        argL.setText(text);
    }

    /**
     * Sets the argument placeholder to the default alphabet in MonoAlphabeticCipher.
     */
    public void setArgumentPlaceholderAlphabet() {
        arg.setText(new MonoAlphabeticCipher().ALPHABET);
    }

    /**
     * Clears the argument placeholder.
     */
    public void clearArgumentPlaceholder() {
        arg.setText("");
    }

    /**
     * Returns the input text.
     * @return the input text
     * @throws IllegalArgumentException if the input is empty
     */
    public String getInputText() throws IllegalArgumentException{
        String input = this.input.getText();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * Returns the argument text.
     * @return the argument text
     * @throws IllegalArgumentException if the argument is empty
     */
    public String getArgumentText() throws IllegalArgumentException{
        String arg = this.arg.getText();
        if (arg.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    /**
     * Returns the selected item in the dropdown.
     * @return the selected item
     */
    public String getSelectedItem() {
        return (String) dropdown.getSelectedItem();
    }
}
