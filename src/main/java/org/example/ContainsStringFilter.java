package org.example;

class ContainsStringFilter implements Filter {
    private final String substring;

    public ContainsStringFilter(String substring) {
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.substring = substring;
    }

    @Override
    public boolean apply(String str) {
        return str.contains(substring);
    }
}
