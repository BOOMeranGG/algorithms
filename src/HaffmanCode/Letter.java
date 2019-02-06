package HaffmanCode;

class Letter {
    Letter leftChild;
    Letter rightChild;
    Character letter;
    int count;
    StringBuilder code;

    public Letter() {
    }

    public Letter(Letter left, Letter right) {
        leftChild = left;
        rightChild = right;
    }

    public Letter(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public String toString() {
        return letter + ": " + code;
    }
}