class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {

        if (array == null || index >= array.length || index < 0) {
            System.out.println("Exception!");
        } else {
            System.out.println(array[index] * array[index]);
        }
    }
}