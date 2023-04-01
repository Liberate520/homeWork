// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;

// public class WriteMD 
// {
//     public static void SaveMD(FamilyTree familyTree) throws IOException, ClassNotFoundException
//     {
//         String pathProject = System.getProperty("user.dir");
//         String pathFile = pathProject.concat("/file.md");
//         File file = new File(pathFile);
//         FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
//         writer.write("##<MD Format>\n");
//         writer.write(familyTree.toString()); 
//         writer.flush(); 
//     }      
// }
