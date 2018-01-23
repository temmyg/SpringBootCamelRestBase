package com.springboot.camel.rest.springboot_camel_rest_base;

import org.apache.camel.Exchange;
import org.apache.camel.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.nio.charset.Charset;

@Component("csvBean")
public class CSVFilerReader {
    public String readFileContent() throws Exception{
        String content = FileUtils.readFileToString(new File("investran.csv"), (Charset) null);
        return content;
    }
}
