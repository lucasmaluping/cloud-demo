import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author Lucas
 * @Date 2020/1/6 16:35
 * @Version 1.0
 */
public class TestCompress {
    @Test
    public void testCom() {
        String srcDir = "d:/compress/put.txt";
        String outPathFile = "d:/compress/put.zip";
        File sourceFile = new File(srcDir);
        String name = sourceFile.getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        try {
            fos = new FileOutputStream(new File(outPathFile));
            zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry(name));
            byte[] buf = new byte[1024];
            int len;
            FileInputStream fis = new FileInputStream(sourceFile);
            while ((len = fis.read(buf)) != -1) {
                zos.write(buf,0,len);
            }
            zos.closeEntry();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFor() {
        String[] str = {"A","B","C","D"};
        Collection list = Arrays.asList(str);
        for(Iterator iter = list.iterator(); iter.hasNext();) {
            Object next = iter.next();
            System.out.println(next);
        }
    }
}
