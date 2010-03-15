/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.injection.naming.test.deployer.unit;

import org.jboss.injection.naming.deployer.EJBSwitchBoardOperatorDeployer;
import org.jboss.injection.naming.deployer.SwitchBoardOperatorDeployer;
import org.jboss.metadata.ejb.jboss.JBossEnterpriseBeanMetaData;
import org.jboss.metadata.ejb.jboss.JBossEnterpriseBeansMetaData;
import org.jboss.metadata.ejb.jboss.JBossMetaData;
import org.jboss.metadata.javaee.spec.EJBReferenceMetaData;
import org.jboss.metadata.javaee.spec.EJBReferencesMetaData;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:jbailey@redhat.com">John Bailey</a>
 */
public class EJBSwitchBoardOperatorDeployerTest extends AbstractSwitchBoardOperatorDeployerTestCase<JBossMetaData>
{
   @Override
   protected Class<JBossMetaData> getMetaDataType()
   {
      return JBossMetaData.class;
   }

   @Override
   protected SwitchBoardOperatorDeployer<JBossMetaData> getDeployer()
   {
      return new EJBSwitchBoardOperatorDeployer();
   }

   @Override
   protected JBossMetaData createMetaData(final String name)
   {
      JBossMetaData jBossMetaData = mock(JBossMetaData.class);
      JBossEnterpriseBeanMetaData jBossEnterpriseBeanMetaData = mock(JBossEnterpriseBeanMetaData.class);
      when(jBossEnterpriseBeanMetaData.getKey()).thenReturn(name);
      when(jBossEnterpriseBeanMetaData.getName()).thenReturn(name);

      EJBReferencesMetaData referencesMetaData = new EJBReferencesMetaData();
      EJBReferenceMetaData referenceMetaData = new EJBReferenceMetaData();
      referenceMetaData.setEjbRefName("testRef");
      referencesMetaData.add(referenceMetaData);

      when(jBossEnterpriseBeanMetaData.getEjbReferences()).thenReturn(referencesMetaData);

      JBossEnterpriseBeansMetaData jBossEnterpriseBeansMetaData = new JBossEnterpriseBeansMetaData();
      jBossEnterpriseBeansMetaData.add(jBossEnterpriseBeanMetaData);

      when(jBossMetaData.getEnterpriseBeans()).thenReturn(jBossEnterpriseBeansMetaData);
      return jBossMetaData;
   }
}