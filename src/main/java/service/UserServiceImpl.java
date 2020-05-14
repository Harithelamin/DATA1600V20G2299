package service;

import menue.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public void saveUser(User user) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fileOut = new FileOutputStream("Users.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(user);
            objectOut.close();
            System.out.println("Ok, brukene er laget opp!");
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet");
        } catch (IOException e) {
            System.out.println("Feil ved initialisering av strømmen");
        }
    }

    @Override
    public List<User> getUsers() {
        ArrayList<User> userArrayList = new ArrayList<>();
        try{
            FileInputStream is = new FileInputStream("Users.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj;
            while ((obj=ois.readObject())!=null){
                userArrayList.add((User) obj);
            }
        }catch (IOException | ClassNotFoundException e){
            e.getStackTrace();
        }


        for(int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i).getUserName());
        }


        //System.out.println(bilInfos.toString());
        return userArrayList;
    }

    @Override
    public boolean checkUser(User user) {
        List<User> users= getUsers();
        for (int i=0; i<users.size();i++)
        {
            if (users.get(i).getUserName()==user.getUserName())
            {
                if (users.get(i).getPass()==user.getPass()){ return true;}
            }
        }
        return false;
    }
}
