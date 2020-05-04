package Bank

class Generator {
    static int nextId = 0

    static int generateId() {
        ++nextId
    }

    static String generateIban() {
        'PL' + new Random().with {
            (1..26).collect { nextInt(10) }.join()
        }
    }
}
