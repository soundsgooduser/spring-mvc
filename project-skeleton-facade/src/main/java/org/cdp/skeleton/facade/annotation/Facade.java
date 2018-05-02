package org.cdp.skeleton.facade.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public @interface Facade {
}
