import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        if(args.length!=1)
        {
            System.out.println(Constant.errorMessage);
            return;
        }
//		Check arguments
        if (args[0].equals(Constant.displayCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String line = getString();
                String names[] = line.split(Constant.separator);
                for (String name : names) {
                    System.out.println(name.trim());
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].equals(Constant.randomAccessCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String line = getString();
                String names[] = line.split(Constant.separator);
                int randomIndex = (int) ((Math.random() * ((names.length-1) - 0)));
                System.out.println(names[randomIndex].trim());
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.addCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                BufferedWriter bufferedReader = getBufferedWriter();
                String subStringToAdd = args[0].substring(1);
                Date date = new Date();
                String timeFormat = Constant.timeFormat;
                DateFormat dateFormat = new SimpleDateFormat(timeFormat);
                String formatedDate = dateFormat.format(date);
                bufferedReader.write(Constant.separator + Constant.singleSpace + subStringToAdd + Constant.updateMessage + formatedDate);
                bufferedReader.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.searchCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String line = getString();
                String names[] = line.split(Constant.separator);
                boolean done = false;
                String subStringToAdd = args[0].substring(1);
                for (int id = 0; id < names.length && !done; id++) {
                    if (names[id].trim().equals(subStringToAdd)) {
                        System.out.println(Constant.foundMessage);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.countCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String line = getString();
                char alphabates[] = line.toCharArray();
                int count = 0;
                for (char space : alphabates) {
                    if (space == Constant.singleSpaceChar) {
                        count++;
                    }
                }
                System.out.println(count+1 + Constant.countMessage);
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else {
            System.out.println(Constant.errorMessage);
        }
    }

    private static BufferedWriter getBufferedWriter() throws IOException {
        BufferedWriter bufferedReader = new BufferedWriter(
                new FileWriter(Constant.inputFileName, true));
        return bufferedReader;
    }

    private static String getString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constant.inputFileName)));
        return bufferedReader.readLine();
    }
}
