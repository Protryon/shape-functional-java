/*
 * Copyright 2014 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shapesecurity.functional.data;

import com.shapesecurity.functional.Unit;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

@CheckReturnValue
public interface Semigroup<T> {
    UnitIdentity UNIT_IDENTITY = new UnitIdentity();
    IntegerAdditive INTEGER_ADDITIVE = new IntegerAdditive();
    IntegerMultiplicative INTEGER_MULTIPLICATIVE = new IntegerMultiplicative();
    StringConcat STRING_CONCAT = new StringConcat();
    BooleanOr BOOLEAN_OR = new BooleanOr();
    BooleanAnd BOOLEAN_AND = new BooleanAnd();

    @Nonnull
    T append(T a, T b);

    class UnitIdentity implements Semigroup<Unit> {
        protected UnitIdentity() {
        }

        @Nonnull
        @Override
        public final Unit append(Unit a, Unit b) {
            return Unit.unit;
        }
    }

    class IntegerAdditive implements Semigroup<Integer> {
        protected IntegerAdditive() {
        }

        @Nonnull
        @Override
        public final Integer append(Integer a, Integer b) {
            return a + b;
        }
    }

    class IntegerMultiplicative implements Semigroup<Integer> {
        protected IntegerMultiplicative() {
        }

        @Nonnull
        @Override
        public final Integer append(Integer a, Integer b) {
            return a * b;
        }
    }

    class StringConcat implements Semigroup<String> {
        protected StringConcat() {
        }

        @Nonnull
        @Override
        public final String append(String a, String b) {
            return a + b;
        }
    }

    class BooleanOr implements Semigroup<Boolean> {
        protected BooleanOr() {
        }

        @Nonnull
        @Override
        public final Boolean append(Boolean a, Boolean b) {
            return a || b;
        }
    }

    class BooleanAnd implements Semigroup<Boolean> {
        protected BooleanAnd() {
        }

        @Nonnull
        @Override
        public final Boolean append(Boolean a, Boolean b) {
            return a && b;
        }
    }
}

