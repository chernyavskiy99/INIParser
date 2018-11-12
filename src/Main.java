import org.ini4j.Ini;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Дмитрий\\IdeaProjects\\Project3\\src\\sample.ini");
        INIFile iniFile;
        iniFile = INIFile.parse(file);

        System.out.println(String.class);
        System.out.println(iniFile.<Double>getParameterFromSection("SampleRate", "ADC_DEV", Double.class));
        //double ans = Double.valueOf((String)iniFile.<Integer>getParameterFromSection("SampleRate", "ADC_DEV", Integer.class));
        //System.out.println(ans * 2);
//        System.out.println(iniFile.<String>getParameterFromSection("SampleRate", "ADC_DEV", String.class));
        System.out.println();
//
//        System.out.println(iniFile.<Double>getParameterFromSection("SampleRate", "NCMD", Double.class));
        System.out.println(iniFile.<Integer>getParameterFromSection("SampleRate", "NCMD", Integer.class));
//        System.out.println(iniFile.<String>getParameterFromSection("SampleRate", "NCMD", String.class));
//        System.out.println();

        System.out.println(iniFile.<Double>getParameterFromSection("ListenTcpPort", "LEGACY_XML", Double.class));
        System.out.println(iniFile.<Integer>getParameterFromSection("ListenTcpPort", "LEGACY_XML", Integer.class));
        System.out.println(iniFile.<String>getParameterFromSection("ListenTcpPort", "LEGACY_XML", String.class));
        System.out.println();

//        System.out.println(iniFile.<Double>getParameterFromSection("DiskCachePath", "COMMON", Double.class));
//        System.out.println(iniFile.<Integer>getParameterFromSection("DiskCachePath", "COMMON", Integer.class));
//        System.out.println(iniFile.<String>getParameterFromSection("DiskCachePath", "COMMON", String.class));
//        System.out.println();
//
//        System.out.println(iniFile.<String>getParameterFromSection("Parameter", "Section", String.class));
//        System.out.println(iniFile.<String>getParameterFromSection("Parameter", "NCMD", String.class));
    }
}
