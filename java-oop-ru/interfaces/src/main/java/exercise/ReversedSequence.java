package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String text;

    ReversedSequence(String string) {
        this.text = string;
    }

    public int length() {
        return text.length();
    }

    @Override
    public String toString() {
        return new StringBuilder(text).reverse().toString();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public String subSequence(int start, int end) {
        return text.substring(start, end);
    }
}
// END
