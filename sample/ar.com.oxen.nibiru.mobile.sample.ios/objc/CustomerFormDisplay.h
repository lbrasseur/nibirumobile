#import <Foundation/Foundation.h>

@interface CustomerFormDisplay : NSObject
@property IBOutlet UIView *container;
@property IBOutlet UILabel *firstNameLabel;
@property IBOutlet UITextField *firstName;
@property IBOutlet UILabel *lastNameLabel;
@property IBOutlet UITextField *lastName;
@property IBOutlet UIButton *save;
@property IBOutlet UIButton *cancel;
@end
