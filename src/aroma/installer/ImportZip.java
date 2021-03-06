/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * @author Nikhil
 * @author Rajat
 */
public class ImportZip extends SwingWorker<Void,Void>{
    ProgressBarUpdater ju;
    Operations op;
    AromaInstaller ai;
    boolean close;

    ImportZip(AromaInstaller aThis, Operations op) {
        this.ai = aThis;
        this.op = op;
        this.close = false;
    }
    
    public void ImportZip(AromaInstaller ai, Operations op){
        
    }
    
    public ArrayList<String> getGroupListFromMVM(MultiValueMap mvm){
        ArrayList<String> arrayList = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            arrayList.add(mapEntry.getKey().toString());
        }
        return arrayList;
    }
    
    @Override
        public Void doInBackground() throws IOException { 
            ju = new ProgressBarUpdater(ai.progressImportZip);
            new java.lang.Thread(ju).start();
            int progress = 0;
            progress += 5;
            ju.setValue(progress);
            ai.textFieldSelectZip.setText(op.existingZipPath);
            MultiValueMap mvm  = this.extractTheZip(op.existingZipPath);
            System.out.println("Map Before : "+op.map);
            ai.groupModel.clear();
            //op.map.putAll(mvm);  
            this.parseMap(mvm);
            for(String grpName : this.getGroupListFromMVM(mvm)){
                if(!op.groupArrayList.contains(grpName))
                    op.groupArrayList.add(grpName);
            }
            //op.groupArrayList.addAll(this.getGroupListFromMVM(mvm));
            System.out.println("Updated GroupList : "+op.groupArrayList);
            System.out.println("Updated Map : "+op.map);
            for(String element : op.groupArrayList){
                String[] temp = element.split("_");
                switch(temp[0]){
                    case "APKs-System":
                        if(!op.systemList.contains(element))
                        op.systemList.add(element);
                        break;
                    case "APKs-Data":
                        if(!op.dataList.contains(element))
                        op.dataList.add(element);
                        break;
                    case "BootAnimations":
                        if(!op.bootAnimList.contains(element))
                        op.bootAnimList.add(element);
                        break;
                    case "Ringtones":
                        if(!op.ringtoneList.contains(element))
                        op.ringtoneList.add(element);
                        break;
                    case "Notifications":
                        if(!op.notifList.contains(element))
                        op.notifList.add(element);
                        break;
                    case "Kernel":
                        if(!op.kernelList.contains(element))
                        op.kernelList.add(element);
                        break;
                }
            }
            //ai.btnApkGroupActionPerformed(null);
            ai.refreshGroupList(ai.lastSelected);
            //ju.setValue(100);
            return null;
        }

        public ArrayList<String> getArrayListFromFileInZip(ZipInputStream zis) throws UnsupportedEncodingException{
            ArrayList<String> list = new ArrayList<>();
            String str = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(zis, "UTF-8"));
            try {
                while (br.ready()) {
                str += (char) br.read();
                }
                System.out.println("String is " + str);
            } catch (IOException e) {
            }
            String array[] = str.split("\n");
            for (String file : array) {
                list.add(file);
            }
            System.out.println("ArrayList obtained is : " + list);
            return list;
        }
        
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            ai.btnBrowseZip.setEnabled(true);
            this.close = true;
            //setCursor(null); //turn off the wait cursor
            //setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ai.textAreaImportZipLog.append("Done!\n");
            ai.frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "Zip Import Successful\nBrowse through the groups to confirm.");
            ai.frame.dispose();
//            System.out.println("Group List after Zip Import : "+op.groupArrayList);
//            System.out.println("System List after Zip Import : "+op.systemList);
//            System.out.println("Data List after Zip Import : "+op.dataList);
//            System.out.print("File List"+op.map.toString());
////            System.out.println("Group List after Zip Import : "+op.groupArrayList);
////            System.out.println("Group List after Zip Import : "+op.groupArrayList);
////            System.out.println("Group List after Zip Import : "+op.groupArrayList);
        }
        
        public void parseMap(MultiValueMap mvm){
            Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry mapEntry = (Map.Entry) it.next();
                //System.out.println("Map.Entry = "+mapEntry.getKey());
                if(!op.map.containsValue(mapEntry.getValue().toString()))
                    op.map.put(mapEntry.getKey().toString(), mapEntry.getValue().toString().replace("]", ""));
            }
        }
        
        public void fillDeleteApkListFromZip(String filePath, ZipInputStream zis) throws UnsupportedEncodingException{
            if(filePath.equals(op.appConfigPath)){
                op.deleteApkList = this.getArrayListFromFileInZip(zis);
            }
        }
        
        public void writeFileFromZip(ZipInputStream zis, File outFile) throws FileNotFoundException, IOException{
            File file = new File(outFile.getParent());
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(outFile);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
        }
        
        public MultiValueMap extractTheZip (String source) throws IOException{ 
            int progressValue = 20;
            ai.setLog("Extracting File from given Location...", ai.textAreaImportZipLog);
            MultiValueMap mvm = new MultiValueMap();
            try{
                File folder = new File("Temp");
                if(!folder.exists()){
                    folder.mkdir();
                }
                ju.setValue(progressValue);
                ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry ze = zis.getNextEntry();
                progressValue += 2;
                ai.setLog("Extracting Data...", ai.textAreaImportZipLog);
                ju.setValue(progressValue);
                while(ze!=null){
                    String filePath = ze.getName();
                    System.out.println("File Name Extracting is.. " + op.getNameFromPath(filePath));
                    
                    this.fillDeleteApkListFromZip(filePath, zis);
                    
                    File outputFile = new File("Temp" + File.separator + filePath);
                    ai.setLog(filePath, ai.textAreaImportZipLog);
                    
                    this.writeFileFromZip(zis, outputFile);
                    
                    if(filePath.startsWith("customize/")){
                        filePath = filePath.substring(filePath.indexOf("/") + 1, filePath.length());
                        String splitName[] = filePath.split("/");
                        switch (splitName[0]){
                            case "APKs-System":
                            case "APKs-Data":
                            case "Ringtones":
                            case "Notifications":
                            case "BootAnimations":    
                            case "Kernels":
                                if(!op.map.containsValue(splitName[1], outputFile.getAbsolutePath()))
                                mvm.put(splitName[1],outputFile.getAbsolutePath());
                        }
                    }
                    ze = zis.getNextEntry();
                    progressValue += 1;
                    ju.setValue(progressValue);
                }
                zis.closeEntry();
                zis.close();
                ju.setValue(100);
                ai.setLog("Crunching Data for Application.....Hold Tight ;)", ai.textAreaImportZipLog);
                System.out.println("Done");
                ju.setValue(100);
            }catch(IOException ex){
                ex.printStackTrace(); 
            }
            return mvm;
        }
}
