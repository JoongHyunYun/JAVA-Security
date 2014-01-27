package net.java.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataEncrypt {
 MessageDigest md;
 String strSRCData = "";
 String strENCData = "";
 
    public DataEncrypt(){}
 public String encrypt_md5(String strData) { 
      try {
         MessageDigest md = MessageDigest.getInstance("MD5"); 
         byte[] bytData = strData.getBytes();
         md.update(bytData);
         byte[] digest = md.digest();  
         for (int i = 0; i < digest.length; i++) {
            strENCData = strENCData + Integer.toHexString(digest[i] & 0xFF).toUpperCase();
         }
      } catch (NoSuchAlgorithmException e) {
         System.out.print("암호화 에러" + e.toString());
      }
       return strENCData;  
   }
 public String encrypt_sha1(String strData) { 
      try {
         MessageDigest md = MessageDigest.getInstance("SHA1"); 
         byte[] bytData = strData.getBytes();
         md.update(bytData);
         byte[] digest = md.digest();  
         for (int i = 0; i < digest.length; i++) {
            strENCData = strENCData + Integer.toHexString(digest[i] & 0xFF).toUpperCase();
         }
      } catch (NoSuchAlgorithmException e) {
         System.out.print("암호화 에러" + e.toString());
      }
       return strENCData.substring(10,25);  
   }
 public static void main(String[] args) {
  DataEncrypt th_pw = new DataEncrypt();
  String mdResult = "", shaResult="";
  mdResult = th_pw.encrypt_md5("admin");
  shaResult = th_pw.encrypt_sha1("admin");
       
  System.out.println("##MD5## ["+mdResult+"]####");
  System.out.println("##SHA1##["+shaResult+"]####");

 }
}

