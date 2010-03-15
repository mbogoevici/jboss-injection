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
package org.jboss.injection.resolve.spi;

import org.jboss.injection.inject.spi.ValueRetriever;

/**
 * The results of executing a Resolver.
 *
 * @author <a href="mailto:jbailey@redhat.com">John Bailey</a>
 */
public class ResolverResult
{
   private ValueRetriever<?> valueRetriever;
   private String refName;
   private String beanName;

   public ResolverResult(String refName, String beanName, ValueRetriever<?> valueRetriever)
   {
      this.valueRetriever = valueRetriever;
      this.refName = refName;
      this.beanName = beanName;
   }

   /**
    * Get the value retriever to use when injecting the reference.
    *
    * @return The value retriever to use a injection time
    */
   public ValueRetriever<?> getValueRetriever()
   {
      return valueRetriever;
   }

   /**
    * Get the resolved MC bean name that is required before injecting the resolved reference.
    *
    * @return The MC bean name
    */
   public String getBeanName()
   {
      return beanName;
   }

   /**
    * Get the reference name.
    * Since a resolver knows the reference name, this allows polymorphic access.
    */
   public String getRefName()
   {
      return refName;
   }
}
