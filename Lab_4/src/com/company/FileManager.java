package com.company;
import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class FileManager {
    private String FileName;
    private File file;

    public FileManager(String FileName){
        this.FileName = FileName;
        file = new File(this.FileName);
    }

    public boolean FileExist(){ //существует ли файл
        if(file.canRead()){
            //System.out.println("Файл существует");
            return true;
        }
        else{
            //System.out.println("Файл не существует");
            return false;
        }
    }

    public void CreateFile() throws IOException{
        file.createNewFile();
    }

    public void WriteInFile(Car car) throws IOException{
        if(FileExist()){
            String res = "";
            DataInputStream InpStrem = new DataInputStream(new FileInputStream(file.getAbsolutePath()));

            try{
            res = InpStrem.readUTF();
            }
            catch (Exception e){
                //Ду нафинг (игнорирует пустой файл)
            }

            res = GetCarString(car) + "\n" + res;
            InpStrem.close();

            DataOutputStream OutStrem = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()));
            OutStrem.writeUTF(res);
            OutStrem.flush();
            OutStrem.close();
        }
        else{
            throw new IOException("Файла не существует");
        }
    }

    public String ReadInFile() throws IOException{
        String res = "";
        byte ress[];

        if(FileExist()){
            DataInputStream InpStrem = new DataInputStream(new FileInputStream(file.getAbsolutePath()));
            res = InpStrem.readUTF();
            System.out.println();
            InpStrem.close();
        }
        return res;
    }

    public String GetCarString(Car car){
        String res = "";
        res += car.getModel() + "*" + car.getNumber() + "*" + car.getColor() + "*" + car.getName() + "*" + car.getScndName() + "*" + car.getAddress() + "*" + car.getDate();
        return res;
    }

    public ArrayList<Car> GetCars() throws IOException{
            ArrayList<Car> ArrCars = new ArrayList<>();
            String Cars[] = ReadInFile().split("\n");

            for(int i = 0; i < Cars.length; ++i){
                String CarCell[] = Cars[i].split("\\*");
                ArrCars.add(new Car(CarCell));
            }

            return ArrCars;
    }

    public ArrayList<Car> GetCarsOnModel(String Model) throws IOException{
        ArrayList<Car> StartCars = GetCars();
        ArrayList<Car> ResCars = new ArrayList<>();

        for(int i = 0; i < StartCars.size(); ++i){
            if ((StartCars.get(i).getModel().compareTo(Model) == 0)){
                ResCars.add(StartCars.get(i));
            }
        }
        return ResCars;
     }

    public String RndAccesRead() throws IOException{
        String NameFile = "Rand.txt";
        RandomAccessFile RndFile = new RandomAccessFile(NameFile, "r");
        String res = "";
        try {
            RndFile.seek(0);
            Byte RES[] = {};
            String buf;
            while ((buf = RndFile.readLine()) != null){
                res += buf;
            }
        }
        catch (EOFException e){
            System.err.println(e);
        }
        return res;
    }

    public String FindOwner(String Number) throws IOException{
        String res = "";
        String Cars = RndAccesRead();
        String ArrCars[] = Cars.split("\\+");

        for(int i = 0; i < ArrCars.length; ++i){
            String Carss[] = ArrCars[i].split("\\*");
            if(Carss[1].compareTo(Number) == 0){
                return "Фамилия: " + Carss[4] + "\nАдресс: " + Carss[5];
            }
        }

        System.out.println();
        return res;
    }

    public String ChangeOwner(String Name, String Date) throws IOException{
        String res = "";
        String Cars = RndAccesRead();
        String ArrCars[] = Cars.split("\\+");

        for(int i = 0; i < ArrCars.length; ++i){
            String Carss[] = ArrCars[i].split("\\*");
        }

        System.out.println();
        return res;
    }
}
