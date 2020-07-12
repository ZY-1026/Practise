package clone.serializable;

import java.io.*;

public class CloneUtils {
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            cloneObj = (T) objectInputStream.readObject();
        } catch (IOException e) {
            new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            new RuntimeException(e);
        }
        return cloneObj;
    }
}
