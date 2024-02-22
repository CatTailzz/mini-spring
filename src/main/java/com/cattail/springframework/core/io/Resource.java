package com.cattail.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 资源处理接口
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
