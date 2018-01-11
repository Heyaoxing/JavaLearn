package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	/**
	 * 创建文件夹
	* @Title: mkdir 
	* @Description: TODO(创建文件夹) 
	* @param  
	* @return boolean    
	* @throws
	 */
	public static boolean mkdir(String path){
		boolean result=false;
		try {
			File file=new File(path);
			if(!file.exists())
				result=file.mkdir();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return result;
	}
	
	/**
	 * 创建新文件
	* @Title: CreateNewFile 
	* @Description: TODO(创建新文件) 
	* @param  
	* @return boolean    
	* @throws
	 */
	public static boolean CreateNewFile(String path){
		boolean result=false;
		try{
			File file=new File(path);
			if(!file.exists())
				result=file.createNewFile();
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		return result;
	}
	
	/**
	 * 往文件追加文本
	* @Title: writeLog 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  
	* @return void    
	* @throws
	 */
	public static void writeLog(String path,String content){
		writeLog(path,content,true);
    }
	/**
	 * 写入文本
	* @Title: writeLog 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  
	* @return void    
	* @throws
	 */
    public static void writeLog(String path,String content,boolean isappend) {
    	FileOutputStream output=null;
    	try {
			File file=new File(path);
			if(!file.exists())
				file.createNewFile();
			StringBuffer sb=new StringBuffer();
			sb.append(content);
			sb.append("\r\n");
			output=new FileOutputStream(file,isappend);
			output.write(sb.toString().getBytes("utf-8"));
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}finally{
			if(output!=null){
				try {
					output.close();
				} catch (IOException e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
    }
    /**
     * 递归删除目录下的所有文件
    * @Title: deleteEveryThing 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param  
    * @return void    
    * @throws
     */
    public static void deleteEveryThing(String path){
    	try {
			File file=new File(path);
			if(!file.exists())
				return ;
			
			if(file.isFile())
			{
				file.delete();
				
			}else{
				File[] files=file.listFiles();
				for(File item:files){
					String filepath = item.getAbsolutePath();
					deleteEveryThing(filepath);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
    }
}
