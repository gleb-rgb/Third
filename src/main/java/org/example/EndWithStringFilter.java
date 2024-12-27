package org.example;

class EndsWithStringFilter implements Filter {
    private final String pattern1;

    public EndsWithStringFilter(String pattern1) {
        if (pattern1 == null || pattern1.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.pattern1 = pattern1;
    }

    @Override
    public boolean apply(String str) {
        return str.endsWith(pattern1);
    }
}