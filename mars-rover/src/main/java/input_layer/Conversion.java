package input_layer;

import types.*;

import java.util.ArrayList;

public interface Conversion <T> {
    public  T convertData (String userInput);

    public  T getData();

    public void setData(T userData);

}
