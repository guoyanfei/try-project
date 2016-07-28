package com.guo.code.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
