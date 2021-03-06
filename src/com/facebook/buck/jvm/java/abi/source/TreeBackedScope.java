/*
 * Copyright 2017-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.jvm.java.abi.source;

import com.facebook.buck.util.exportedfiles.Nullable;
import com.sun.source.tree.Scope;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * An implementation of {@link Scope} that uses only the information available from a
 * {@link com.sun.source.tree.Tree}. This results in an incomplete implementation; see documentation
 * for individual methods and {@link com.facebook.buck.jvm.java.abi.source} for more information.
 */
abstract class TreeBackedScope implements Scope {
  @Nullable
  private final Scope enclosingScope;
  @Nullable
  private final TreeBackedTypeElement enclosingClass;

  protected TreeBackedScope(
      @Nullable Scope enclosingScope,
      @Nullable TreeBackedTypeElement enclosingClass) {
    this.enclosingScope = enclosingScope;
    this.enclosingClass = enclosingClass;
  }

  @Override
  @Nullable
  public Scope getEnclosingScope() {
    return enclosingScope;
  }

  @Override
  @Nullable
  public TypeElement getEnclosingClass() {
    return enclosingClass;
  }

  @Override
  @Nullable
  public ExecutableElement getEnclosingMethod() {
    // TODO(jkeljo): Maybe implement this for annotation processors
    return null;
  }
}
