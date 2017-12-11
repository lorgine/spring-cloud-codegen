package com.venus.cloud.codegen.generator;

/**
 * <p>Title: Nepxion Skeleton Generator</p>
 * <p>Description: Nepxion Skeleton Generator For Freemarker</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.IOException;

import com.venus.cloud.codegen.exception.SkeletonException;
import com.venus.cloud.codegen.generator.server.PomXmlGenerator;
import com.venus.cloud.codegen.generator.server.java.ServerApplicationClassGenerator;
import com.venus.cloud.codegen.generator.server.resources.ApplicationPropertiesGenerator;
import com.venus.cloud.codegen.property.SkeletonProperties;

import freemarker.template.TemplateException;

public class GeneratorService {
    public void generator(String path, SkeletonProperties skeletonProperties) throws SkeletonException, TemplateException, IOException {
        // 创建Java类文件
        // 模板文件ServerApplication.java.template必须和ServerApplicationClassGenerator.java放在同一个目录下，下同
        new ServerApplicationClassGenerator(path, "server", skeletonProperties).generate();

        // 创建文件到resources目录下
        new ApplicationPropertiesGenerator(path, "server", skeletonProperties).generate();

        // 创建文件到目录下
        new PomXmlGenerator(path, "server", skeletonProperties).generate();
    }
}