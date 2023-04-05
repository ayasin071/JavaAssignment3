package exceptions;

public abstract class validateMaxMinException {
    public static void Validate(int Max , int Min) throws MaxMinException {
        if (Max<=Min){
            throw new MaxMinException("Max Players is less then Min!");
        }
    }
    
}
