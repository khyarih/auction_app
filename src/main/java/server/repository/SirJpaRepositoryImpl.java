package server.repository;

import com.google.gson.Gson;
import server.annotation.TargetFile;
import server.exception.SirJpaAddException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SirJpaRepositoryImpl<K, T> implements SirJpaRepository<K, T>{

    private static void checkAnnotated(Class<?> objectClass) throws SirJpaAddException{

        if(!objectClass.isAnnotationPresent(TargetFile.class)){
            throw new SirJpaAddException("the class"
                    + objectClass.getSimpleName()
                    + " is not Annotated with @TargetFile");
        }
    }

    @Override
    public void add(K key, T object) throws SirJpaAddException {
        if(Objects.isNull(object)){
            throw new SirJpaAddException("the object to save is null");
        }

        Class<?> objectClass = object.getClass();
        checkAnnotated(objectClass);

        try{

            Gson gson  = new Gson();
            List<T> data = new ArrayList<>();
            data.add(object);

            String jsonFormat = gson.toJson(data);
            String targetFile = objectClass.getAnnotation(TargetFile.class).fileName();

            if(! targetFile.isEmpty()){
                List<String> lines = Files.readAllLines(Paths.get(targetFile));
                List o = gson.fromJson(lines.get(0),  data.getClass());

                Files.write(Paths.get(targetFile), jsonFormat.getBytes());
            }

        }catch(IOException e){
            throw new SirJpaAddException("An error occurred in object saving");
        }

    }

    @Override
    public List<T> getAll() {
        //TODO: implements me
        return null;
    }

    @Override
    public T getById(K key) {
        //TODO: implements me
        return null;
    }

    @Override
    public void update(K key, T value) {
        //TODO: implements me

    }

    @Override
    public void delete(K key) {
        //TODO: implements me

    }
}
