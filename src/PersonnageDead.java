public class PersonnageDead extends Exception{
    public PersonnageDead(){
    }

    @Override
    public String toString() {
        return "Sorry! You just died, game over!";
    }
}
