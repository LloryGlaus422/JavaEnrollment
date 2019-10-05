/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

/**
 *
 * @author 2ndyrGroupC
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class File {

    private ArrayList<ArrayList> list = new ArrayList();
    private BufferedWriter accFile = null;
    private BufferedWriter courseFile = null;
    private BufferedWriter infoFile = null;
//constructors

    public File() {
    }

    public File(BufferedWriter accF, BufferedWriter infoFile, BufferedWriter courseFile) {
        this.accFile = accF;
        this.courseFile = courseFile;
        this.infoFile = infoFile;
    }
//setters and getters

    public ArrayList getList() {
        return list;
    }

    public BufferedWriter getAccFile() {
        return accFile;
    }

    public void setAccFile(BufferedWriter accFile) {
        this.accFile = accFile;
    }

    public BufferedWriter getCourseFile() {
        return courseFile;
    }

    public void setCourseFile(BufferedWriter courseFile) {
        this.courseFile = courseFile;
    }

    public BufferedWriter getInfoFile() {
        return infoFile;
    }

    public void setInfoFile(BufferedWriter infoFile) {
        this.infoFile = infoFile;
    }

    @Override
    public String toString() {
        return "File{" + "accFile=" + accFile + ", courseFile=" + courseFile + ", infoFile=" + infoFile + '}';
    }
//sending to array

    public void sendAccount(ArrayList<ArrayList> list) throws IOException {
        accFile = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt", false));
        try {
            for (ArrayList item : list) {
                if (item != null) {
                    String send = String.format("%s %s %s \n", item.get(0), item.get(1), item.get(2));
                    accFile.write(send);
                   

                }
            }
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("Close");
            accFile.close();
        }
    }

    public void sendPersonalInfo(ArrayList<ArrayList> list) throws IOException {
        infoFile = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Info.txt", false));
        try {

            for (ArrayList item : list) {
                if (item != null) {
                    String send = String.format("%s %s %s %s %s \n", item.get(0), item.get(1), item.get(2), item.get(3), item.get(4));
                    infoFile.write(send);
      
                }
            }
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("Close");
            infoFile.close();
        }
    }

    public void sendCourse(ArrayList<ArrayList> list) throws IOException {
        courseFile = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Course.txt", false));
        try {
            for (ArrayList item : list) {
                if (item != null) {
                    String send = String.format("%s %s %s %s %s \n", item.get(0), item.get(1), item.get(2), item.get(3), item.get(4));
                    courseFile.write(send);

                }
            }
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("Close");
            courseFile.close();
        }
    }

    public void sendArray(BufferedReader reader) throws IOException {
        ArrayList<String> tempList = new ArrayList();
        try {
            String line = reader.readLine();
            while (line != null) {
                for (String item : line.split(" ")) {
                    
                    tempList.add(item);
                }
                list.add(tempList);
                tempList = new ArrayList();
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
