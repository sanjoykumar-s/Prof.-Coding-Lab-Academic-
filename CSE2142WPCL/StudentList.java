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
                String names[] = getString().split(Constant.separator);
                for (String name : names) {
                    System.out.println(name.trim());
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].equals(Constant.randomAccessCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String names[] = getString().split(Constant.separator);
                int randomIndex = (int) ((Math.random() * ((names.length-1) - 0)));
                System.out.println(names[randomIndex].trim());
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.addCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                BufferedWriter bufferedReader = getBufferedWriter();
                DateFormat dateFormat = new SimpleDateFormat(Constant.timeFormat);
                bufferedReader.write(Constant.separator + Constant.singleSpace + args[0].substring(1) + Constant.updateMessage + dateFormat.format(new Date()));
                bufferedReader.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.searchCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String names[] = getString().split(Constant.separator);
                for (int id = 0; id < names.length; id++) {
                    if (names[id].trim().equals(args[0].substring(1))) {
                        System.out.println(Constant.foundMessage);
                        break;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.endMessage);
        } else if (args[0].contains(Constant.countCommand)) {
            System.out.println(Constant.waitingMessage);
            try {
                String names[] = getString().split(Constant.separator);
                System.out.println(names.length);
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
