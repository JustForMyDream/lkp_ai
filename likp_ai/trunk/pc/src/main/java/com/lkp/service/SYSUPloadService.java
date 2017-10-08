package com.lkp.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 *
 * 摄影师上传业务
 */
public interface SYSUPloadService {
    Serializable uploadYingji(String orderid, String title, String des, String music, String[] pic);
}
