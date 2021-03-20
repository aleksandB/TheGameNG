package com.github.TheGameNG.functions;


import com.github.TheGameNG.entities.Team;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadWriteExcel {

    private static final Logger log = LoggerFactory.getLogger(ReadWriteExcel.class);
    private static final String PATH_FILE = "G:\\sr01001\\java\\TheGameNG\\src\\main\\resources\\example\\temp.xlsx";

    public List<Team> ReadExcelFileTeams(){
        List<Team> allTeams = new ArrayList<>();
        try{
           FileInputStream excelFile = new FileInputStream(new File(PATH_FILE));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row;

            Iterator rows = sheet.rowIterator();
            int count = 0;
            while(rows.hasNext()){
                if(count==0){
                    count++;
                    continue;
                }else {
                    row = (XSSFRow) rows.next();
                    allTeams.add(new Team(count,row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),1,0,0,0,0,0,0,0,0));
                    count++;
                }
            }

        }catch (IOException e){
            log.error("Not applicable format of file");
        }
        System.out.println(allTeams.size());
        return allTeams;
    }

    public void convertMultipart(MultipartFile multipartFile){
         try{
            multipartFile.transferTo(new File("G:\\sr01001\\java\\TheGameNG\\src\\main\\resources\\example\\temp.xlsx"));
        }catch (FileNotFoundException e){
            log.error("File not found exception");
        }catch (IOException e){
            log.error("File not applicable format");
        }
    }


    public void testPrint(List<Team> teams){
        for(Team team : teams){
            log.info("Id: " + team.getId()+
                    " Team Name: " + team.getTeamName() +
                    " Team zone play: " + team.getTeamPlayZone() +
                    " Team Rank: " + team.getTeamRank());
        }
    }
}
