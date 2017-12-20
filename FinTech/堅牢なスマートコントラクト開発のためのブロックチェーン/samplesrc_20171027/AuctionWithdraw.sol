pragma solidity ^0.4.11;
contract AuctionWithdraw {
  address public highestBidder;  // �ō��񎦊z
  uint public highestBid;  // �ō��z�񎦃A�h���X
  mapping(address => uint) public userBalances;  // �ԋ��z���Ǘ�����}�b�v
  
  /// �R���X�g���N�^
  function AuctionWithdraw() payable public{
    highestBidder = msg.sender;
    highestBid = 0;
  }
  
  /// Bid�p�̊֐�
  function bid() public payable {
    // bid�����݂̍ō��z�����傫�����Ƃ��m�F����
    require(msg.value > highestBid);

    // �ō��z�񎦃A�h���X�̕ԋ��z���X�V����
    userBalances[highestBidder] += highestBid;
        
    // �X�e�[�g�X�V
    highestBid = msg.value;
    highestBidder = msg.sender;
  }
  
  function withdraw() public{
    // �ԋ��z��0���傫�����Ƃ��m�F����
    require(userBalances[msg.sender] > 0);
    
    // �ԋ��z��ޔ�
    uint refundAmount = userBalances[msg.sender];
    
    // �ԋ��z���X�V
    userBalances[msg.sender] = 0;
    
    // �ԋ�����
    if(!msg.sender.send(refundAmount)) {
      revert();
    }
  }
}