package github.com.nikuyoshi;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * Copyright 2016 Hiroki Uchida
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SystemConfigManager {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        SystemConfig mbean = new SystemConfig(1);
        ObjectName name = new ObjectName("github.com.nikuyoshi:type=SystemConfig");
        mBeanServer.registerMBean(mbean, name);
        do{
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Thread Count=" + mbean.getThreadCount());
        } while (mbean.getThreadCount() != 0);
    }
}
