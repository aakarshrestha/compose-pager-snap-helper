Release version [![](https://jitpack.io/v/aakarshrestha/compose-pager-snap-helper.svg)](https://jitpack.io/#aakarshrestha/compose-pager-snap-helper)

# compose-pager-snap-helper

It is a pager style snapping library in horizontal orientation. Provide the width used in the item in horizontally scrolling list, and it will calculate when to snap to the target view.

# Download
Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add it in your app build.gradle:
```
dependencies {
    implementation "com.github.aakarshrestha:compose-pager-snap-helper:[version]"
}
```

**Compose pager snap helper demo** 

![composePagerSnapHelper](https://user-images.githubusercontent.com/15058925/114441102-f56fa100-9b98-11eb-8f23-73adad72cfe4.gif)

# Usage

```
@Composable
fun ComposePagerSnapHelper(
    width: Dp,
    content: @Composable (NestedScrollConnection, LazyListState, Dp) -> Unit
)

```
* @param width width of the item in horizontally scrolling list.
* @param content a block which describes the content. Inside this block, you will have access to [NestedScrollConnection], [LazyListState] and [Dp].

**Implementation:** Check out the sample app to see how it works.
```
ComposePagerSnapHelper(
        width = 320.dp, //required
        content = { connection, listState, width -> //these params are provided by the method itself, add these params below.
            LazyRow(
                state = listState, //add listState param
                modifier = Modifier.nestedScroll(connection) //add connection param in nestedScroll method
            ) {
                items(count = count) { item ->
                    Card(
                        modifier = Modifier
                            .width(width)
                            .height(350.dp)
                            .padding(
                                start = if (item == 0) 16.dp else 16.dp,
                                top = 16.dp, bottom = 16.dp,
                                end = if (item == 4) 16.dp else 8.dp),
                        backgroundColor = Color.LightGray, shape = RoundedCornerShape(12)
                    ) {
                        //Put text or whatever here

                    }
                }
            }
        }
    )

```

# License

```
Copyright 2021 Aakar Shrestha

Permission is hereby granted, free of charge, 
to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS 
OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN 
AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH 
THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

```
