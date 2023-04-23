class Proverka {
    public static boolean pr(String a) {
        String[] units = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean t = false;
        for (String unit : units) {
            if (a.equals(unit)) {
                t = true;
                break;
            }
        }
        return t;
    }
}