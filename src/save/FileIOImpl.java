package save;

import java.io.*;


// public class FileIOImpl implements FileIO {

//   @Override
//   public void writeToFile(String fileName, String data) {
//     try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//       writer.write(data);
//     } catch (IOException e) {
//       e.printStackTrace();
//     }
//   }

//   @Override
//   public String readFromFile(String fileName) {
//     StringBuilder sb = new StringBuilder();
//     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//       String line;
//       while ((line = reader.readLine()) != null) {
//         sb.append(line).append("\n");
//       }
//     } catch (IOException e) {
//       e.printStackTrace();
//     }
//     return sb.toString();
//   }
// }
