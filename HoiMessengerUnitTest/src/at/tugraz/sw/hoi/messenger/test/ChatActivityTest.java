package at.tugraz.sw.hoi.messenger.test;

import android.test.ActivityInstrumentationTestCase2;
import at.tugraz.sw.hoi.messenger.ChatActivity;



public class ChatActivityTest extends ActivityInstrumentationTestCase2<ChatActivity> {
//
//  private ChatActivity mActivity;
//
//  private static final String TEST_MESSAGE = "Hello Receiver";
//
  public ChatActivityTest() {
    super(ChatActivity.class);
  }
//
//  public void setUp() throws Exception {
//    super.setUp();
//    mActivity = getActivity();
//    setActivityInitialTouchMode(true);
//  }
//
//  protected void tearDown() throws Exception {
//    super.tearDown();
//  }
//
//  public void testPreconditions() 
//  {
//
//    final Button addButton = (Button) mActivity.findViewById(R.id.btAddContact);
//
//    assertNotNull("mActivity is null", mActivity);
//    assertNotNull("addButton is null", addButton);
//
//  }
//
//  public void SendButtonTest() {
//
//    final Button sendButton = (Button) mActivity.findViewById(R.id.btSend);
//    final EditText senderMessageEditText = (EditText) mActivity.findViewById(R.id.etText);
//
//    Instrumentation.ActivityMonitor receiverActivityMonitor = getInstrumentation()
//        .addMonitor(ChatActivity.class.getName(), null, false);
//    getInstrumentation().runOnMainSync(new Runnable() {
//      @Override
//      public void run() {
//        senderMessageEditText.requestFocus();
//      }
//    });
//    getInstrumentation().waitForIdleSync();
//
//    getInstrumentation().sendStringSync(TEST_MESSAGE);
//    getInstrumentation().waitForIdleSync();
//
//    TouchUtils.clickView(this, sendButton);
//    assertNotNull(senderMessageEditText);
//    assertEquals("Wrong received message", TEST_MESSAGE, senderMessageEditText.getText().toString());
//
//    getInstrumentation().removeMonitor(receiverActivityMonitor);
//  }
//
//  public void addContactDialogTest() {
//
//    AddContactDialog newFragment = AddContactDialog.newInstance();
//    newFragment.show(getActivity().getSupportFragmentManager(), "addContactDialog");
//
//    assertTrue(newFragment.getDialog().isShowing());
//
//    newFragment.getDialog().dismiss();
//  }
//
//  public void editMailDialogTest() {
//
//    EditEmailDialog newFragment = EditEmailDialog.newInstance();
//    newFragment.show(getActivity().getSupportFragmentManager(), "editEmailDialog");
//
//    assertTrue(newFragment.getDialog().isShowing());
//
//    newFragment.getDialog().dismiss();
//  }
//
}