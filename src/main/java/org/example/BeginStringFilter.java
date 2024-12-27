package org.example;

interface Filter {
    boolean apply(String str);
}

class BeginStringFilter implements Filter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        return str.startsWith(pattern);
    }
}