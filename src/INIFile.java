import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class INIFile {
    private static List<Section> sectionList = new ArrayList<>();

    INIFile(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public static INIFile parse(File file){
        List<Section> sectionList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            if (!file.getName().matches("\\w+\\.ini")) {
                throw new FileFormatException("Incorrect file format");
            }
            while (scanner.hasNextLine()) {
                String sectionName = scanner.nextLine();
                while (scanner.hasNextLine() && !sectionName.matches("\\[\\w+\\]")) {
                    sectionName = scanner.nextLine();
                }
                Map<String, String> mapLine = new HashMap<>();
                if (sectionName.matches("\\[\\w+\\]")) {
                    sectionName = sectionName.substring(1, sectionName.length() - 1);
                }
                String line;
                while (scanner.hasNextLine() && !(line = scanner.nextLine()).trim().isEmpty() &&
                        line.substring(0, 1).matches("[\\w]")) {
                    String[] words = line.split(" ");
                    mapLine.put(words[0], words[2]);
                }
                Section section = new Section(sectionName, mapLine);
                sectionList.add(section);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FileFormatException e) {
            e.printStackTrace();
        }
        return new INIFile(sectionList);
    }

    <T> Object getParameterFromSection(String parameter, String section, Class<T> type) {
        int index = sectionList.indexOf(new Section(section));
        try {
            if (index != -1) {
                Map<String, String> map = sectionList.get(index).getMapLine();
                if (map.containsKey(parameter)) {
                    String value = map.get(parameter);
                    return value; //object
                    //return type.getDeclaredConstructor(String.class).newInstance(value);
                } else {
                    throw new ElementDoesNotFoundException("Parameter doesn't exist");
                }
            } else {
                throw new ElementDoesNotFoundException("Section doesn't exist");
            }
        } catch (IllegalArgumentException | ElementDoesNotFoundException /*| InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException*/ e) {
            e.printStackTrace();
        }
        return null;
    }
}
