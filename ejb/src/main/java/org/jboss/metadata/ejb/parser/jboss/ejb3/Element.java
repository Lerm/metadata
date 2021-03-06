/*
 * JBoss, Home of Professional Open Source.
 * Copyright (c) 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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
package org.jboss.metadata.ejb.parser.jboss.ejb3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:cdewolf@redhat.com">Carlo de Wolf</a>
 */
public enum Element
{
   // must be first
   UNKNOWN(null),
   ASSEMBLY_DESCRIPTOR("assembly-descriptor"),
   EJB("ejb"),
   ENTERPRISE_BEANS("enterprise-beans"),
   ACTIVATION_CONFIG("activation-config")
   ;

   private final String name;

   Element(String name)
   {
      this.name = name;
   }

   public String getLocalName()
   {
      return name;
   }

   private static final Map<String, Element> MAP;

   static
   {
      final Map<String, Element> map = new HashMap<String, Element>();
      for (Element element : values())
      {
         final String name = element.getLocalName();
         if(name != null) map.put(name, element);
      }
      MAP = map;
   }

   public static Element forName(final String localName)
   {
      final Element element = MAP.get(localName);
      return element == null ? UNKNOWN : element;
   }
}
