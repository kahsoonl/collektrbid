package com.example.bid.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bid.R
import com.example.bid.detail.domain.model.ChatModel
import com.example.bid.detail.viewmodel.BidDetailUserIntent
import com.example.bid.detail.viewmodel.BidDetailViewState
import com.example.bid.overview.domain.model.CollectableModel
import com.example.foundation.design.drawFadingEdges
import com.example.foundation.design.reusable_component.AppButton
import com.example.foundation.design.reusable_component.AppButtonWhite
import com.example.foundation.design.reusable_component.GenericModalBottomSheet
import com.example.foundation.design.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidDetailDataLoaded(
    viewState: BidDetailViewState.DataLoaded,
    userIntent: (BidDetailUserIntent) -> Unit,
) {
    val chatBoxTextState = remember { mutableStateOf("") }
    val chatBoxTextValue = remember { derivedStateOf { chatBoxTextState.value } }
    val chatListState = rememberLazyListState()
    val collectableInfoBottomSheetState = remember { mutableStateOf(false) }
    val showBottomSheetState = remember { derivedStateOf { collectableInfoBottomSheetState.value } }
    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize(),
    ) {
        BidDetailToolbar()
        Spacer(modifier = Modifier.weight(1f))
        BidDetailChatWindow(
            messages = viewState.chatList,
            chatState = chatListState,
        )
        BidDetailChatInput(
            inputValue = chatBoxTextValue,
            onValueChange = {
                chatBoxTextState.value = it
            }
        )
        BidDetailItemInfo(
            collectableModel = viewState.collectableModel,
            onItemInfoClick = {
                collectableInfoBottomSheetState.value = true
            },
        )
        BidButtonRow(
            userIntent = userIntent,
            collectableModel = viewState.collectableModel,
        )
        Spacer(modifier = Modifier.height(16.dp))
        BidDetailItemInfoBottomSheet(
            bottomSheetState = showBottomSheetState,
            onDismiss = {
                collectableInfoBottomSheetState.value = false
            },
            sheetState = sheetState,
            collectableModel = viewState.collectableModel,
        )
    }
}


@Composable
fun BidDetailToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = "user profile image",
            modifier = Modifier
                .clip(
                    CircleShape,
                )
                .background(Color.White),
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "BidPosterNameHere",
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}

@Composable
fun BidDetailChatWindow(
    messages: List<ChatModel>,
    chatState: LazyListState,
) {
    LazyColumn(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            )
            .drawFadingEdges(chatState),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = chatState,
    ) {
        items(messages) { item ->
            BidDetailChatMessage(item)
        }
    }

    LaunchedEffect(messages.size) {
        chatState.animateScrollToItem(chatState.layoutInfo.totalItemsCount)
    }
}

@Composable
fun BidDetailChatMessage(
    chatModel: ChatModel,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = "user profile image",
            modifier = Modifier
                .clip(
                    CircleShape,
                )
                .background(Color.White),
        )
        Spacer(Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = chatModel.posterName,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
            )
            Text(
                text = chatModel.message,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }
}

@Composable
fun BidDetailChatInput(
    inputValue: State<String>,
    onValueChange: (String) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Surface(
            modifier = Modifier
                .height(40.dp)
                .weight(1f)
                .padding(
                    horizontal = 16.dp,
                ),
            shape = RoundedCornerShape(16.dp),
            color = Color.Black.copy(
                alpha = 0.3f,
            ),
        ) {
            BasicTextField(
                value = inputValue.value,
                enabled = true,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                    ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send,
                    keyboardType = KeyboardType.Text,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                onValueChange = onValueChange,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(4.dp),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        if (inputValue.value.isEmpty()) {
                            Text(
                                text = stringResource(R.string.bid_chat_input_hint),
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(
                    shape = CircleShape,
                ),
            colors = IconButtonDefaults.iconButtonColors().copy(
                containerColor = AppTheme.colors.primary,
                contentColor = Color.White,
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_send),
                contentDescription = "bidding chat send button",
            )
        }
    }
}

@Composable
fun BidDetailItemInfo(
    collectableModel: CollectableModel,
    onItemInfoClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onItemInfoClick.invoke()
            }
            .background(
                color = AppTheme.colors.greyBgColor.copy(
                    alpha = 0.7f,
                ),
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = collectableModel.collectableName,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(
                    R.string.bid_item_info_price,
                    collectableModel.collectableBids.last().bidAmount
                ),
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .padding(
                    8.dp,
                ),
            painter = painterResource(R.drawable.ic_next),
            contentDescription = "product info more info icon",
            tint = Color.White,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidDetailItemInfoBottomSheet(
    bottomSheetState: State<Boolean>,
    onDismiss: () -> Unit,
    sheetState: SheetState,
    collectableModel: CollectableModel,
) {
    if (bottomSheetState.value) {
        GenericModalBottomSheet(
            sheetState = sheetState,
            onDismiss = onDismiss,
            sheetContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.summoned_skull_test,
                        ),
                        contentDescription = "collectable image",
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit,
                    )
                    Text(
                        text = collectableModel.collectableName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = collectableModel.collectableDesc,
                    )
                    Text(
                        text = stringResource(R.string.bid_detail_bid_history),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(collectableModel.collectableBids) { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_person),
                                    contentDescription = "user profile image",
                                    modifier = Modifier
                                        .clip(
                                            CircleShape,
                                        )
                                        .background(Color.White),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = item.userName,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = stringResource(
                                        R.string.bid_item_info_price,
                                        item.bidAmount
                                    ),
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun BidButtonRow(userIntent: (BidDetailUserIntent) -> Unit, collectableModel: CollectableModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
            ),
    ) {
        AppButtonWhite(
            buttonModifier = Modifier
                .weight(1f),
            buttonText = stringResource(R.string.bid_custom_button_text),
            onClickListener = {

            },
        )
        Spacer(
            modifier = Modifier.width(8.dp),
        )
        AppButton(
            buttonModifier = Modifier
                .weight(1f),
            buttonText = stringResource(
                R.string.bid_increment_button_text,
                collectableModel.collectableBids.last().bidAmount + 10
            ),
            onClickListener = {
                userIntent.invoke(BidDetailUserIntent.Bid)
            },
            isEnabled = true,
        )
    }
}