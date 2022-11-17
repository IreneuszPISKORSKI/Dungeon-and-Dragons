public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(){
    }

    @Override
    public String toString() {
        /**
         * method to display error
         */
        return "Congratulations! You've reached the end of the board!";
    }
}
