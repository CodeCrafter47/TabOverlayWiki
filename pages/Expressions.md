Expressions are used at various places in the configuration of the plugin. So here's a definition of what is an expression:

**Note on the semantic:** The result of an expression can be a boolean value (true/ false), a number or a string. In most
 places the plugin requires a boolean result. If the expression does not give a boolean result, the result will be converted, 
 i.e. a number will be converted to `false` if it is `0` and to `true` in all other cases, a string will be converted to 
 `true` if it equals `"true"` all other strings will be converted to `false`.

Literals
--------
1. Any number is an expression, so the following are valid expressions. Examples:
   ```
   0
   1000
   -7
   47.2
   ```

2. A string in double quotes is a valid expression. Examples:
   ```
   "Hello World"
   ""
   ```

3. The boolean literals are `true`, `false` and `all`(same as `true`).

Placeholders:
-------------

Any placeholder is a valid expression. See the [full list of placeholders](Placeholders) for more information.

Examples:
```
${player name}
${viewer uuid}
${playerset:global size}
${server:lobby online}
${viewer server tps}
```

Binary Operators
----------------

`<Expression> <Binary Operator> <Expression>` is a valid expression. The following binary operators are available:

| Operator | Semantic                                                                                |
| -------- | --------------------------------------------------------------------------------------- |
| `and`    | Evaluates to `true` only if both operands evaluate to `true`.                           |
| `or`     | Evaluates to `true` if at least one of the operands evaluate to `true`.                 |
| `==`     | Tests the operands for equality.                                                        |
| `!=`     | `true` if the operands are not equal, false otherwise.                                  |
| `<`      | Compares two numbers, true if the first operand is smaller than the second operand.     |
| `<=`     | Compares two numbers, true if the first operand is smaller or equal the second operand. |
| `>`      | Compares two numbers, true if the first operand is greater than the second operand.     |
| `>=`     | Compares two numbers, true if the first operand is greater or equal the second operand. |
| `.`      | Concatenates two strings.                                                               |

Examples:
```
${viewer name} == "CodeCrafter47"
${viewer ping} <= 50 
50 < ${viewer ping} <= 150 
${viewer server} == "survival" and ${viewer world} == "world_nether"
```

Parenthesis
-----------
`( <Expression> )` is a valid expression. Parenthesis can be used to prevent ambiguities.

Example:
```
(${viewer server} == "survival" and ${viewer world} == "world_nether") or (${viewer group} == "Admin")
```

Negation
--------
You can use `!` to negate boolean expressions.

Examples:
```
!${server:lobby online}
!(${viewer server} == "survival" and ${viewer world} == "world_nether")
```